CREATE TABLE Animal (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age VARCHAR(100),
    gender VARCHAR(100) NOT NULL,
    species VARCHAR(100) NOT NULL,
    colour VARCHAR(100),
    breed VARCHAR(100),
    neutered VARCHAR(100),
    microChipped VARCHAR(100),
    healthConditions VARCHAR(100),
    paired VARCHAR(30),
    status VARCHAR(100),
    imgUrl VARCHAR
);