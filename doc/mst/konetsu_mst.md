| カラム                | 型       | 詳細                                |
| ------------------ | ------- | --------------------------------- |
| konetsu_id         | int     | ID。必須。主キー。重複不可。自動連番。              |
| konetsu_year_month | int     | 支払い年月。必須。                         |
| user_id            | int     | ユーザーID。必須。外部キー(user_mstのuser_id)。 |
| item_id            | int     | 項目ID。必須。外部キー(item_mstのitem_id)。   |
| konetsu_amount     | int     | 光熱費。必須。                           |
| konetsu_added_date   |timestamp   |登録年月日。必須。データ登録時、自動入力。 |