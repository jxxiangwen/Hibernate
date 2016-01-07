CREATE TABLE a_grade(
  annotation_grade_id int PRIMARY KEY AUTO_INCREMENT,
  annotation_grade_name VARCHAR(20) NOT NULL ,
  annotation_grade_desc VARCHAR(255)
);

CREATE TABLE a_student(
  student_id int PRIMARY KEY AUTO_INCREMENT,
  student_name VARCHAR(20) NOT NULL ,
  gender VARCHAR(4),
  birthday TIMESTAMP,
  post_code VARCHAR(10) NOT NULL ,
  phone VARCHAR(20),
  address VARCHAR(255),
  picture TEXT,
  annotation_grade_id int
);
ALTER TABLE a_student
ADD CONSTRAINT FK_a_student_annotation_grade_id FOREIGN KEY (annotation_grade_id) REFERENCES a_grade (annotation_grade_id);
