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

function checkOut() {
        const item = [
            {id: "beefRd", name: "牛肉餡餅", price: 50},
            {id: "porkRd", name: "豬肉餡餅", price: 50},
            {id: "coldNoodleRd", name: "涼麵", price: 50},
            {id: "winterMelonTeaRd", name: "冬瓜茶", price: 20},
            {id: "soyMilkRd", name: "有糖豆漿", price: 20},
            {id: "sugarFreeSoyMilkRd", name: "無糖豆漿", price: 20}
        ];

        let summery = "您的購物車內容如下：\n";
        let total = 0;

        item.forEach(item => {
            const qty = parseInt(document.getElementById(item.id).value) || 0;
            if (qty > 0) {
                const subtotal = qty * item.price;
                summery += `${item.name} X ${qty} = ${subtotal} 元\n`;
                total += subtotal;
            }
        });
        if (total === 0) {
            alert("購物車內目前是空的。");
            return;
        }

        summery += `\n總金額：${total} 元\n`;

        const confirmCheckout = confirm(summery + "\n\n是否確定結帳?\n\n按「確定」結帳，按「取消」繼續選購");

        if (confirmCheckout) {
            window.location.href = "checkout.jsp";
        }

}


