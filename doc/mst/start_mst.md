| カラム                | 型       | 詳細                                |
| ------------------ | ------- | --------------------------------- |
| start_id         | int     | ID。必須。主キー。重複不可。自動連番。              |
| start_year_month | int     | 支払い年月。必須。                         |
| user_id            | int     | ユーザーID。必須。外部キー(user_mstのuser_id)。 |
| start_amount     | int     | 生活費。必須。                           |
| start_added_date   |timestamp   |登録年月日。必須。データ登録時、自動入力。 |
