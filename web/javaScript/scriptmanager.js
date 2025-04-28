window.onload = function () {
    const now = new Date();
    const hours = now.getHours();

    if (hours >= 20) {
        fetchSalesData();
    } else {
        document.getElementById("salesReport").innerHTML = "<p style='color: red;'>目前尚未開放查詢，請於晚上8點後刷新頁面。</p>";
    }
};

function fetchSalesData() {
    fetch("getDailySales")
        .then(response => {
            if (!response.ok) {
                throw new Error("伺服器錯誤");
            }
            return response.json();
        })
        .then(data => {
            renderSalesReport(data);
        })
        .catch(error => {
            console.error("抓取銷售資料失敗：", error);
            document.getElementById("salesReport").innerHTML = "<p style='color: red;'>無法取得銷售資料，請稍後再試。</p>";
        });
}

function renderSalesReport(data) {
    const container = document.getElementById("salesReport");

    if (data.length === 0) {
        container.innerHTML = "<p>今日尚無銷售紀錄</p>";
        return;
    }

    let totalRevenue = 0;
    let html = "<table border='1' cellpadding='8' style='border-collapse: collapse; margin: 0 auto;'>";
    html += "<tr><th>品項名稱</th><th>銷售數量（份）</th><th>小計（元）</th></tr>";

    data.forEach(item => {
        const subtotal = item.unitprice * item.totalSold;
        totalRevenue += subtotal;

        html += `<tr>
                    <td>${item.productName}</td>
                    <td>${item.totalSold}</td>
                    <td>${subtotal}</td>
                 </tr>`;
    });

    html += "</table>";

    html += `<h2 style="margin-top: 20px; color: green;">今日總營業額：${totalRevenue} 元</h2>`;

    container.innerHTML = html;
}
