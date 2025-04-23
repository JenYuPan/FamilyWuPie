window.onload = function () {
    setInterval(() => {
        fetch("getLatestOrder")
            .then(res => res.json())
            .then(data => {
                if (data.orderId) {
                    renderOrder(data);
                }
            });
    }, 3000);
};

function renderOrder(data) {
    const orderDiv = document.getElementById("orderBlock");
    let html = `<h2>訂單編號:${data.orderId}</h2>`;
    html += "<ul>";

    data.items.forEach(item => {
        html += `<p>${item.name}: &nbsp; ${item.price} &nbsp; X ${item.quantity} &nbsp; =  ${item.price * item.quantity} &nbsp;元</p>`;
    });
    html += "</ul>"

    html += `<p><strong>總金額：${data.total}</strong></p>`;

    html += `
        <button onclick="confirmPayment('${data.orderId}')">已付款</button>
        <button onclick="cancelPayment('${data.orderId}')">取消訂單</button>
            `;
    orderDiv.innerHTML=html;
}

function confirmPayment(orderId){
    
}