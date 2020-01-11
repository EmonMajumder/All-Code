<?php

use Illuminate\Database\Seeder;

class RolesTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('roles')->insert([
            'name' => 'User Administrator',
        ]);
        DB::table('roles')->insert([
            'name' => 'Post Moderator',
        ]);
        DB::table('roles')->insert([
            'name' => 'Theme Manager',
        ]);
    }
}
