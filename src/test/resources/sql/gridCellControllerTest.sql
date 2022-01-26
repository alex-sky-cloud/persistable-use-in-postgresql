INSERT INTO mesh(id, name, cell_size) VALUES
  (5550005551, 'Foo', 12);

INSERT INTO mesh_column(id, number, mesh_id) VALUES
  (55500055530, 1, 5550005551);

INSERT INTO mesh_line(id, number, mesh_id) VALUES
  (55500055540, 1, 5550005551);