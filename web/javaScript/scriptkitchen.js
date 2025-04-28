window.onload = function () {
    setInterval(fetchOrders, 3000);
};

function fetchOrders() {
    fetch("getKitchenOrders")
        .then(res => res.json())
        .then(data => {
        renderKitchenOrders(data);
    })
        .catch(err=>{
            console.error("無法取的訂單列表",err);
            document.getElementById("kitchenOrderList")
                .innerHTML = "<p style='color:red;'>無法取得訂單資料</p>";
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
        html += `<div class="order-block" id="order-${order.orderId}">
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
    })
        .then(res => res.json())
        .then(date=>{
            if (date.status==="ok"){
                fetchOrders();
            }else{
                alert("錯誤："+date.message);
            }
        })
        .catch(err=>console.error("出餐錯誤：",err))
}

function markCancel(orderId){
    if(!confirm("確定取消本筆訂單?")){
        return;
    }
    fetch("kitchenAction",{
        method:"POST",
        headers:{"Content-Type":"application/x-www-form-urlencoded"},
        body:"orderId="+encodeURIComponent(orderId)+"&action=cancel"
    })
        .then(res => res.json())
        .then(data =>{
            if(data.status==="ok"){
                fetchOrders();
            }else{
                alert("錯誤："+data.message);
            }
        })
        .catch(err=> console.error("取消錯誤",err))
}
