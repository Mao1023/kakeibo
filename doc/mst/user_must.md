| カラム               | 型          | 詳細                   |
| ----------------- | ---------- | -------------------- |
| user_id           | int        | ID。必須。主キー。重複不可。自動連番。 |
| user_name         | vachar(50) | ユーザー名。必須。重複禁止。       |
| user_password_hash|varchar(255)  |パスワードのハッシュ。必須。     |
| user_admin        |boolean     |管理者権限の有無。デフォルトは0。     |
| user_added_date   |timestamp   |登録年月日。必須。データ登録時、自動入力。 |
