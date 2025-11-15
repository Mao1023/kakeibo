| カラム       | 型           | 詳細                                |
| --------- | ----------- | --------------------------------- |
| item_id   | int         | ID。必須。主キー。重複不可。自動連番。              |
| user_id   | int         | ユーザーID。必須。外部キー(user_mstのuser_id)。 |
| item_name | varchar(50) | 項目名。必須。                           |
| item_type | int         | マスタ種別。                            |
| item_added_date   |timestamp   |登録年月日。必須。データ登録時、自動入力。 |
