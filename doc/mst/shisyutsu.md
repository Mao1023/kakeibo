| カラム                | 型       | 詳細                                |
| ------------------ | ------- | --------------------------------- |
| shisyutsu_id         | int     | ID。必須。主キー。重複不可。自動連番。              |
| shisyutsu_year_month | int     | 支出年月。必須。                         |
| user_id            | int     | ユーザーID。必須。外部キー(user_mstのuser_id)。 |
| item_id            | int     | 項目ID。必須。外部キー(item_mstのitem_id)。   |
| shisyutsu_name     | varchar(100)     | 支出名。必須。          |
| shisyutsu_amount     | int     | 支出金額。必須。                           |
| shisyutsu_added_date   |timestamp   |登録年月日。必須。データ登録時、自動入力。 |
