function increase(id) {
    const input = document.getElementById(id);
    let val = parseInt(input.value) || 0;
    input.value = val + 1;
}

function decrease(id) {
    const input = document.getElementById(id);
    let val = parseInt(input.value) || 0;
    if (val > 0) input.value = val - 1;
}

function generateOrderId(prefix, number) {
    const numStr = number.toString().padStart(6, '0');
    return prefix + numStr;
}

function checkOut() {
    const prefix = "AA";
    const todayOrderCount = 7;
    const orderId = generateOrderId(prefix, todayOrderCount + 1);

    const item = [
        {id: "beefRd", name: "牛肉餡餅", price: 50},
        {id: "porkRd", name: "豬肉餡餅", price: 50},
        {id: "coldNoodleRd", name: "涼麵", price: 50},
        {id: "winterMelonTeaRd", name: "冬瓜茶", price: 20},
        {id: "soyMilkRd", name: "有糖豆漿", price: 20},
        {id: "sugarFreeSoyMilkRd", name: "無糖豆漿", price: 20}
    ];

    const selectedItems = [];
    let summery = "您的購物車內容如下：\n";
    let total = 0;

    item.forEach(item => {
        const qty = parseInt(document.getElementById(item.id).value) || 0;
        if (qty > 0) {
            selectedItems.push({id: item.id, name: item.name, price: item.price, quantity: qty});
            const subtotal = qty * item.price;
            summery += `${item.name} X ${qty} = ${subtotal} 元\n`;
            total += subtotal;
        }
    });

    if (selectedItems.length === 0) {
        alert("購物車內目前是空的。");
        return;
    }

    summery += `\n總金額：${total} 元\n`;

    const confirmCheckout = confirm(summery + "\n\n是否確定結帳?\n\n按「確定」結帳，按「取消」繼續選購");
    if (!confirmCheckout) return;

    sessionStorage.setItem("orderId", orderId);
    sessionStorage.setItem("orderItems", JSON.stringify(selectedItems));
    sessionStorage.setItem("orderTotal", total);

    window.location.href = "payment.jsp";

}

// 付款連結
function submitPayment() {
    const orderId = sessionStorage.getItem("orderId");
    const orderItems = sessionStorage.getItem("orderItems");
    const orderTotal = sessionStorage.getItem("orderTotal");

    if (!orderId || !orderItems || !orderTotal) {
        alert("找不到訂單資料，請重新點餐!");
        return;
    }

    const payload = {
        orderId: orderId,
        items: JSON.parse(orderItems),
        total: orderTotal
    };

    fetch("submitOrder", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(payload)
    })
        .then(res => {
            if (res.ok) {
                window.location.href = "waiting.jsp?orderId=" + orderId;
            } else {
                alert("送出訂單失敗，請稍後再試");
            }

        })
        .catch(err=>{
            console.error("送出錯誤：",err);
            alert("無法連線至伺服器");
        });
}


