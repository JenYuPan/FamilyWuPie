window.onload = function () {
    setInterval(() => {
        fetch("getLatestOrder")
            .then(res => {
                if (!res.ok) throw new Error("API not found or server error");
                return res.json();
            })
            .then(data => {
                if (data.orderId) {
                    renderOrder(data);
                } else {
                    document.getElementById("orderBlock").innerHTML =
                        "<p style='margin-left: 20px; color: gray;'>目前沒有待處理的訂單</p>";
                }
            })
            .catch(err => {
                console.error("fetch error:", err);
                document.getElementById("orderBlock").innerHTML =
                    "<p>無法取得訂單資料</p>";
            });
    }, 3000);
};

function renderOrder(data) {
    const orderDiv = document.getElementById("orderBlock");
    let html = `<h2>訂單編號: ${data.orderId}</h2>`;
    html += "<ul>";
    data.items.forEach(item => {
        html += `<li>${item.name}: ${item.price} × ${item.quantity} = ${item.price * item.quantity} 元</li>`;
    });
    html += "</ul>";
    html += `<p><strong>總金額：${data.total} 元</strong></p>`;
    html += `
        <button onclick="confirmPayment('${data.orderId}')">已付款</button>
        <button onclick="cancelPayment('${data.orderId}')">取消訂單</button>
    `;
    orderDiv.innerHTML = html;
}

function confirmPayment(orderId) {
    fetch("confirmPayment", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "orderId=" + encodeURIComponent(orderId)
    })
        .then(res=>res.json())
        .then(data=>{
            if(data.status==="ok"){
                alert("訂單完成付款")
            }else {
                alert("錯誤"+data.message);
            }
        });
}

function cancelPayment(orderId) {
    fetch("cancelPayment", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "orderId=" + encodeURIComponent(orderId)
    })
        .then(res=>res.json())
        .then(data => {
            if(data.status==="ok"){
                alert("訂單已取消！")
            }else {
                alert("錯誤:"+data.message);
            }

    });
}
