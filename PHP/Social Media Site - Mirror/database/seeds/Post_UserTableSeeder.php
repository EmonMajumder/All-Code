<?php

use Illuminate\Database\Seeder;

class Post_UserTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('post_user')->insert([
            'post_id' => '1',
            'user_id' => '2'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '1',
            'user_id' => '4'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '2',
            'user_id' => '4'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '1',
            'user_id' => '7'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '2',
            'user_id' => '8'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '6',
            'user_id' => '2'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '5',
            'user_id' => '12'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '1',
            'user_id' => '11'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '4',
            'user_id' => '11'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '7',
            'user_id' => '3'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '2',
            'user_id' => '5'
        ]);
        DB::table('post_user')->insert([
            'post_id' => '5',
            'user_id' => '1'
        ]);
    }
}

