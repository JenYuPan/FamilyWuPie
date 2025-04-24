window.onload = function () {
    const orderId = sessionStorage.getItem("orderId");
    const orderItems = JSON.parse(sessionStorage.getItem("orderItems"));
    const total = sessionStorage.getItem("orderTotal");

    const orderInfo = document.getElementById("orderInfo");

    if (!orderId || !orderItems || !total) {
        orderInfo.innerHTML = "找不到訂單資料，請重新點餐";
    } else {
        let html = `<p>訂單編號：<strong>${orderId}</strong></p>`;
        html += "<ul>";
        orderItems.forEach(item => {
            html += `<p>${item.name}:${item.price} × ${item.quantity}=${item.price*item.quantity}</p>`;
        });
        html += "</ul>";
        html += `<p><strong>總金額：${total} 元</strong></p>`;
        orderInfo.innerHTML = html;
    }


// 輪詢付款狀態
    setInterval(() => {
        fetch("checkPaymentStatus?orderId=" + orderId)
            .then(res => res.json())
            .then(data => {
                if (data.paid === true) {
                    window.location.href = "successPage.jsp?orderId="+orderId;
                } else if (data.cancelled === true) {
                    window.location.href="cancelPage.jsp"
                }
            });
    }, 3000);

};