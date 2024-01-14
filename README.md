<h1>
  DGT factory Zadanie
</h1>
<br/>
<h2>Intro</h2>
This is the repo for DGT demo transaction app. Code is fully working so feel free to play around.
<br/>
Database is hosted on mongoDB Atlas Cloud so no setup is required.
<h2>Endpoints</h2>
<strong>POST</strong> localhost:8080/transactions
<br/><br/>
example request body:
<br/>

{
    "name": "order",
    "type": "international"
}
<br/>
<br/>
<strong>possible transaction types:</strong> international, national
<h2></h2>
<strong>GET</strong> localhost:8080/transactions/(:id)/fee
<br/>
<br/>
existing ids: 65a3d4d0120a7841bef4e83b, 65a3d809e5bd0f20eb9931e2
<br/>
<strong>Note:</strong> each id contains different transaction type  
