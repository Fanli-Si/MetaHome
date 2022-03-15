# MetaHome
CSIS3275

The project is aiming to provide a household managing solution.

We all have been through situations such as running out toliet paper or forgetten expired products. The first one is inconvient and the latter one is a big source for food wastage. MetaHome is a solution for these situations. This web application is desgined to track and remind household prodcuts including cleaning suppliers, persoanl care, groceries and fresh products. 

Household purchase household suppliers from different sources, Amazon Subscription, Save-on-Food, London Drugs, etc. So one way to track what users have at home is let user "mannualy" input data. Scanning receipts is an excellent source for these data.

To set reminder when to refill, for exmaple, toliet paper, options are provided to users. They can set up their own timeframe, such as every two months. If things run out before the setted time, users would make the purchase agian. These type of change will be recorded in the system and become the data source for better prediction (This is the incremented part. This part is based on enough user behavior data collected through the app and build a machine learning model for prediciton)

The second type of reminder is for long preserved food. Products such as dry spaghetti and canned soup have a long shelf time. To ask users update everytime they consumer the products is quite invasive, and our goal is to minimize the waste caused "forgetten" products. The reminder is to set before expiration date so that users can know they have these products needs attention. In addtition, if users have purchased exactly the same products agian, we can safely assume the old one has ran out. The application can pop a notificaiton for users to confirm the update and reset the reminders.

With all the user data accumulate over time, we can profile what they prefer in food, or clean suppliers. Then we can have price matching and recommendation system implemented. When a product is not available in their usual stores, an alternative will be provided. (This is based on the web applicaiton build a connection with other shopping platform, such as Amazon, Walmart, LD and etc.



