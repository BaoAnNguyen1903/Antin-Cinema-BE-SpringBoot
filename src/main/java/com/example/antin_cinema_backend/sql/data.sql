insert into	users(name, dob, gender, phone, email, username, password, avatar, points, status, role) values
('Nguyễn Đình Bảo Ân', '2004-03-19', 'M', '0987689426', 'anndb1903@gmail.com', 'a', 'a', 'avatar', 0, 1, 'A'),
('Nguyễn Trà My', '2004-06-30', 'F', '0000000000', 'tramyvim@gmail.com', 'b', 'b', 'avatar', 0, 1, 'U'),
('Trmeo', '2004-06-30', 'F', '111111111', 'trmeobel@gmail.com', 'c', 'c', 'avatar', 0, 1, 'U');

insert into khach(fullname, phone, email) values
('Dang Thanh Vinh', '09001001000', 'blabla@gmail.com'),
('Chau Thanh Trung', '09001001001', 'blablaaa@gmail.com'),
('Nguyen Dinh THi', '09001001002', 'blabadala@gmail.com');

insert into movie_type(movie_type_name) values
('Hài'),
('Tình cảm'),
('Gia đình'),
('Hoạt hình'),
('Tâm lý'),
('Hành động'),
('Tội phạm'),
('Hồi hộp'),
('Kinh dị'),
('Bí ẩn'),
('Khoa học viễn tưởng');

insert into movie_rated(movie_rated_name) values
('P - PHIM ĐƯỢC PHÉP PHỔ BIẾN RỘNG RÃI ĐẾN MỌI ĐUỐI TƯỢNG'),
('K - PHIM ĐƯỢC PHỔ BIẾN ĐẾN NGƯỜI XEM DƯỚI 13 TUỔI VÀ CÓ NGƯỜI BẢO HỘ ĐI KÈM'),
('T13 - PHIM CẤM PHỔ BIẾN ĐẾN KHÁN GIẢ DƯỚI 13 TUỔI'),
('T16 - PHIM CẤM PHỔ BIẾN ĐẾN KHÁN GIẢ DƯỚI 16 TUỔI'),
('T18 - PHIM CẤM PHỔ BIẾN ĐẾN KHÁN GIẢ DƯỚI 18 TUỔI'),
('C - PHIM KHÔNG ĐƯỢC PHÉP PHỔ BIẾN');

insert into movie_language(movie_language_name) values
('Phụ đề Tiếng Anh'),
('Tiếng Việt - Phụ đề Tiếng Anh'),
('Phụ đề Tiếng Việt'),
('Phụ đề Tiếng Anh'),
('Lồng Tiếng Việt'),
('meo meo, gâu gâu');
