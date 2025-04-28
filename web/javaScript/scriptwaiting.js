window.onload = function () {
    const orderId = sessionStorage.getItem("orderId");
    const orderItems = JSON.parse(sessionStorage.getItem("orderItems"));
    const total = sessionStorage.getItem("orderTotal");

    const orderInfo = document.getElementById("orderInfo");

    if (!orderId || !orderItems || !total) {
        orderInfo.innerHTML = "<p style='color: red;'>找不到訂單資料，請重新點餐！</p>";
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
    const intervalId = setInterval(() => {
        fetch("checkPaymentStatus?orderId=" + encodeURIComponent(orderId))
            .then(res => res.json())
            .then(data => {
                if (data.paid === true) {
                    clearInterval(intervalId);
                    window.location.href = "successPage.jsp";
                } else if (data.cancelled === true) {
                    clearInterval(intervalId);
                    window.location.href="cancelPage.jsp"
                }
            })
            .catch(err =>{
                console.error("輪詢失敗",err);
            })
    }, 3000);

};