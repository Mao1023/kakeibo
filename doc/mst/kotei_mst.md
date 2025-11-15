| カラム              | 型         | 詳細                                |
| ---------------- | --------- | --------------------------------- |
| kotei_id         | int       | ID。必須。主キー。重複不可。自動連番。              |
| user_id          | int       | ユーザーID。必須。外部キー(user_mstのuser_id)。 |
| item_id          | int       | 項目ID。必須。外部キー(item_mstのitem_id)。   |
| kotei_amount     | int       | 固定費。必須。                           |
| kotei_added_date | timestamp | 登録年月日。必須。データ登録時、自動入力。             |
