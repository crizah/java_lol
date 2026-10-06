create table if not EXISTS users(
    id uuid primary key default gen_random_uuid(),
    name text not null,
    email text not null,
    phone_number text not null,
    status user_status default 'INVITED' ,
    role system_role not null,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

create table if not exists user_passwords(
    user_id UUID PRIMARY KEY REFERENCES users(id) ON DELETE CASCADE,
    password_hash TEXT NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT NOW()
)
