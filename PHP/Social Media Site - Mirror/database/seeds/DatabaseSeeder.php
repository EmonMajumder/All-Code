<?php

use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
        $this->call([
            RolesTableSeeder::class,
            UsersTableSeeder::class,
            Role_UserTableSeeder::class,
            ThemesTableSeeder::class,
            PostsTableSeeder::class,
            Post_UserTableSeeder::class,
            CommentsTableSeeder::class
        ]);
    }
}
