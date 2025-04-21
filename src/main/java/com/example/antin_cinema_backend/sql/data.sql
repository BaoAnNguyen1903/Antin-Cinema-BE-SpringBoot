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

insert into movie(movie_name, movie_description, movie_director, movie_actor, mtid, movie_time, mlid, mrid, poster, banner, openday, closeday, movie_status) values
('Gọi Tôi Là Huyền Thoại', 'Một câu chuyện cảm động về hành trình trưởng thành và vượt qua chính mình.', 'Trần Hữu Tâm', 'Lý Hải, Thái Hòa, Ninh Dương Lan Ngọc', 5, '120 phút', 2, 4, 'poster_huyenthoai.jpg', 'banner_huyenthoai.jpg', '2025-04-25', '2025-06-01', 1),

('Thám Tử Lừng Danh Conan: Bản Tình Ca Màu Đỏ', 'Conan cùng các đồng đội tham gia phá án tại Osaka với nhiều tình tiết gay cấn và lãng mạn.', 'Yasuichiro Yamamoto', 'Minami Takayama, Wakana Yamazaki, Rikiya Koyama', 10, '110 phút', 3, 3, 'poster_conan.jpg', 'banner_conan.jpg', '2025-04-20', '2025-06-15', 1),

('Avengers: Cuộc Chiến Vô Cực', 'Các siêu anh hùng hợp lực để ngăn chặn Thanos hủy diệt vũ trụ.', 'Anthony Russo, Joe Russo', 'Robert Downey Jr., Chris Evans, Scarlett Johansson', 11, '149 phút', 1, 5, 'poster_avengers.jpg', 'banner_avengers.jpg', '2025-04-10', '2025-05-31', 1),

('Mắt Biếc', 'Một chuyện tình tuổi học trò đầy cảm xúc dựa trên tiểu thuyết của Nguyễn Nhật Ánh.', 'Victor Vũ', 'Trần Nghĩa, Trúc Anh, Khánh Vân', 2, '117 phút', 2, 3, 'poster_matbiec.jpg', 'banner_matbiec.jpg', '2025-03-15', '2025-04-30', 0),

('Frozen II', 'Elsa và Anna khám phá bí mật về sức mạnh phép thuật và nguồn gốc hoàng gia.', 'Chris Buck, Jennifer Lee', 'Idina Menzel, Kristen Bell, Josh Gad', 4, '103 phút', 5, 1, 'poster_frozen2.jpg', 'banner_frozen2.jpg', '2025-04-01', '2025-05-15', 1);
