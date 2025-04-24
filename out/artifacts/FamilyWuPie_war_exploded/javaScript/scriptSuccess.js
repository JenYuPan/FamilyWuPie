window.onload = function () {
    const orderId = sessionStorage.getItem("orderId");
    const orderItems = JSON.parse(sessionStorage.getItem("orderItems"));
    const total = sessionStorage.getItem("orderTotal");

    if (!orderId || !orderItems || !total) {
        document.getElementById("orderInfo").innerHTML = "找不到訂單資訊";
        return;
    }

    let html = `<p>訂單編號：<strong>${orderId}</strong></p><ul>`;
    orderItems.forEach(item => {
        html += `<li>${item.name}:${item.price} X ${item.quantity} = ${item.price * item.quantity} 元</li>`;
    });
    html += `</ul><p><strong>總金額：${total} 元</strong></p>`;
    document.getElementById("orderInfo").innerHTML = html;

    // 將訂單送到廚房（後端 Servlet）
    fetch("sendToKitchen", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            orderId: orderId,
            items: orderItems,
            total: total
        })
    }).then(res => {
        if (!res.ok) {
            console.error("送至廚房失敗");
        }
    });

    setTimeout(() => {
        window.location.href = "orderPage.jsp";
    }, 10000);
};