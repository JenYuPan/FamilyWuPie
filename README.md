這是一個餡餅店的專案，使用者有四面向
  1.客戶在現場的點餐平台
  2.櫃台人員的收費與訂單確認平台
  3.廚房的出餐通知與取消平台
  4.管理者查帳平台

  這裡練習了JDBC、JSP、CSS、JavaScript、servlet的操作，
  目前就更新到這裡
  
  客戶端的進入點在orderPage.jsp
  櫃台端的進入點在counterPage.jsp
  廚房端的進入點是在kitchenPage.jsp
  每日查帳頁面是在managerPage.jsp
  
  主要功能說明：
  參閱場景示意圖
  顧客餘點餐櫃檯點餐，經由櫃台人員確認收到款項，櫃台操作介面確認訂單，
  訂單內容傳至廚房，廚房接單畫面出現訂單內容，確認出餐後按下出餐，該餐點
  相關資料紀錄於資料庫。並且於每日晚上八點產生當日銷售與營業額的報告。
