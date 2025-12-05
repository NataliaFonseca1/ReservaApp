-- ============================
-- SEED DESTINATIONS
-- ============================

INSERT INTO destinations (name, country, city, description, image_url, base_price) VALUES
('Paris', 'França', 'Paris',
 'Paris, a cidade das luzes, famosa por sua arquitetura histórica, museus de renome e gastronomia refinada.',
 'https://images.unsplash.com/photo-1502602898657-3e91760cbb34?auto=format&fit=crop&w=1200&q=80',
 3200.00),

('Nova York', 'Estados Unidos', 'Nova York',
 'Nova York oferece arranha-céus icônicos, vida cultural intensa e vistas urbanas inesquecíveis.',
 'https://cdn.pixabay.com/photo/2021/12/09/11/53/empire-state-building-6858030_1280.jpg',
 2900.00),

('Rio de Janeiro', 'Brasil', 'Rio de Janeiro',
 'O Rio combina praias espetaculares, montanhas e pontos turísticos reconhecidos mundialmente.',
 'https://media.istockphoto.com/id/847316730/pt/foto/sugarloaf-mountain-in-rio-de-janeiro-brazil.jpg?s=2048x2048&w=is&k=20&c=cZJKO8LPPBIftbHTj7qYpHPmXHJfBhsB3eT29hCEa-tokio',
 1800.00),

('Tóquio', 'Japão', 'Tóquio',
 'Tóquio mistura tradição e futurismo em uma metrópole vibrante e cheia de cultura.',
 'https://cdn.pixabay.com/photo/2020/01/31/07/10/city-4807268_1280.jpg',
 4500.00),

('Roma', 'Itália', 'Roma',
 'Roma é um museu a céu aberto repleto de história, monumentos e gastronomia incrível.',
 'https://cdn.pixabay.com/photo/2019/10/12/15/28/the-coliseum-4544105_1280.jpg',
 3100.00),

('Londres', 'Reino Unido', 'Londres',
 'Londres reúne cultura, história e modernidade em uma das cidades mais influentes do mundo.',
 'https://images.unsplash.com/photo-1467987506553-8f3916508521?auto=format&fit=crop&w=1200&q=80',
 3400.00),

('Lisboa', 'Portugal', 'Lisboa',
 'Lisboa encanta com seus miradouros, colinas e charme europeu tradicional.',
 'https://images.unsplash.com/photo-1505761671935-60b3a7427bad?auto=format&fit=crop&w=1200&q=80',
 2000.00),

('Barcelona', 'Espanha', 'Barcelona',
 'Barcelona combina arquitetura única, praias e vida urbana vibrante.',
 'https://cdn.pixabay.com/photo/2014/08/26/14/11/street-427998_1280.jpg',
 2300.00),

('Cape Town', 'África do Sul', 'Cidade do Cabo',
 'Cidade do Cabo oferece paisagens naturais deslumbrantes entre montanhas e oceano.',
 'https://images.unsplash.com/photo-1500375592092-40eb2168fd21?auto=format&fit=crop&w=1200&q=80',
 2800.00),

('Queenstown', 'Nova Zelândia', 'Queenstown',
 'Queenstown é destino de aventura e belezas naturais, com montanhas e lagos cristalinos.',
'https://images.unsplash.com/photo-1502786129293-79981df4e689?auto=format&fit=crop&w=1200&q=80',
 3600.00);


-- ============================
-- SEED TRIPS
-- ============================

INSERT INTO trips (destination_id, start_date, end_date, seats, price, location) VALUES
(1, '2026-03-10', '2026-03-17', 18, 5200.00, 'Roteiro clássico por Paris'),
(1, '2026-09-05', '2026-09-12', 15, 4990.00, 'Paris romântica no outono'),

(2, '2026-06-01', '2026-06-09', 25, 4800.00, 'Nova York – Manhattan essencial'),
(2, '2026-11-10', '2026-11-18', 18, 4500.00, 'Nova York iluminada no fim de ano'),

(3, '2026-01-15', '2026-01-21', 30, 1500.00, 'Rio – praias e pontos turísticos'),
(3, '2026-12-26', '2027-01-02', 20, 2100.00, 'Réveillon no Rio de Janeiro'),

(4, '2026-04-08', '2026-04-18', 12, 8200.00, 'Tóquio – tradição e modernidade'),
(4, '2026-10-10', '2026-10-22', 15, 8900.00, 'Tóquio no outono japonês'),

(5, '2026-05-12', '2026-05-20', 22, 4700.00, 'Roma histórica e gastronômica'),
(5, '2026-12-01', '2026-12-10', 18, 4400.00, 'Roma e mercados de fim de ano'),

(6, '2026-06-12', '2026-06-19', 20, 5300.00, 'Londres – museus e clássicos'),
(6, '2026-09-22', '2026-09-29', 20, 5100.00, 'Londres e arredores'),

(7, '2026-04-20', '2026-04-26', 24, 2100.00, 'Lisboa e miradouros da cidade'),

(8, '2026-07-01', '2026-07-08', 26, 2400.00, 'Barcelona – Gaudí e praias'),

(9, '2026-11-05', '2026-11-12', 16, 3000.00, 'Cape Town – montanha e litoral'),

(10, '2026-02-15', '2026-02-22', 12, 6500.00, 'Queenstown – aventuras ao ar livre');


-- ============================
-- SEED BOOKINGS
-- ============================

INSERT INTO booking (trip_id, client_name, client_email, people, status, total_price, created_at) VALUES
(1, 'Cindy Vilela', 'cindy@example.com', 2, 'CONFIRMED', 10400.00, now()),
(8, 'Paulo Souza', 'paulo@example.com', 1, 'PENDING', 2400.00, now());
