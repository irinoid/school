--liquibase formatted sql

--changeSet iKap:1
CREATE INDEX student_name ON student (name);
CREATE INDEX faculty_name_color ON faculty (name, color);