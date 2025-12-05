CREATE TABLE IF NOT EXISTS destinations (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  country VARCHAR(100),
  city VARCHAR(100),
  description TEXT,
  image_url VARCHAR(512),
  base_price DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS trips (
  id BIGSERIAL PRIMARY KEY,
  destination_id BIGINT REFERENCES destinations(id) ON DELETE CASCADE,
  start_date DATE,
  end_date DATE,
  seats INTEGER,
  price DOUBLE PRECISION,
  location VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS booking (
  id BIGSERIAL PRIMARY KEY,
  trip_id BIGINT REFERENCES trips(id) ON DELETE CASCADE,
  client_name VARCHAR(255) NOT NULL,
  client_email VARCHAR(255),
  people INTEGER,
  status VARCHAR(50),
  total_price DOUBLE PRECISION,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);
