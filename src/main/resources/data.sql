truncate table `user`;
truncate table `role`;

insert into `role` (`id`, `name`) values (1, 'ROLE_ADMIN');
insert into `role` (`id`, `name`) values (2, 'ROLE_USER');

-- Value of the `password` is generated by ./gradlew encodePassword -Pargs="test"
-- See build.gradle
insert into `user` (`id`, `username`, `password`, `enabled`, `role_id`, `created_at`, `updated_at`) values (1, 'test', 'c3bf653f3addf1102cecb043a423915aa345b85131e7ea0f84108839415ded416574799c648a1289', true, 1, 0, 0);