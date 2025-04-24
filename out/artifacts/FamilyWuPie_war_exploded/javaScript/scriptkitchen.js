window.onload = function () {
    setInterval(fetchOrders, 3000);
};

function fetchOrders() {
    fetch("getKitchenOrders")
        .then(res => res.json()).then(data => {
        renderKitchenOrders(data);
    });
}

function renderKitchenOrders(data) {
    const container = document.getElementById("kitchenOrderList");
    if (!data || data.length === 0) {
        container.innerHTML = "<p style='color: green'>目前沒有待處理的訂單</p>";
        return
    }

    let html = "";

    data.forEach(order => {
        html += `<div class="order-block">
                  <h2>訂單編號：${order.orderId}</h2><ul>`;
        order.items.forEach(item => {
            html += `<li>${item.name} X ${item.quantity} 個</li>`;
        });
        html += `</ul>           
            <button onclick="markDone('${order.orderId}')">已出餐</button>
            <button onclick="markCancel('${order.orderId}')">已取消</button>
                </div>`
    });

    container.innerHTML=html;
}

function markDone(orderId){
    fetch("kitchenAction",{
        method:"POST",
        headers:{"Content-Type":"application/x-www-form-urlencoded"},
        body:"orderId="+encodeURIComponent(orderId)+"&action=done"
    }).then(()=>fetchOrders());
}

function markCancel(orderId){
    if(!confirm("確定取消本筆訂單?")){
        return;
    }
    fetch("kitchenAction",{
        method:"POST",
        headers:{"Content-Type":"application/x-www-form-urlencoded"},
        body:"orderId="+encodeURIComponent(orderId)+"&action=cancel"
    }).then(()=>fetchOrders());
}
