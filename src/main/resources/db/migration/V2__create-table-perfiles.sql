create table perfiles(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    usuario_id bigint not null,

    primary key(id),

    constraint fk_perfiles_usuario_id foreign key(usuario_id) references usuarios(id)
);
