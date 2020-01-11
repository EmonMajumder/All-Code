<?php

use Illuminate\Database\Seeder;

class UsersTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('users')->insert([
            'name' => 'admin',
            'email' => 'admin@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'emon',
            'email' => 'emon@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'amit',
            'email' => 'amit@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'parul',
            'email' => 'parul@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'pranesh',
            'email' => 'pranesh@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'animesh',
            'email' => 'animesh@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'ashima',
            'email' => 'ashima@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'anindita',
            'email' => 'anindita@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'modhurima',
            'email' => 'modhurima@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'rajat',
            'email' => 'rajat@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'bijan',
            'email' => 'bijan@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'kakoli',
            'email' => 'kakoli@mirror.com',
            'password' => bcrypt('123456'),
        ]);

        DB::table('users')->insert([
            'name' => 'aadrita',
            'email' => 'aadrita@mirror.com',
            'password' => bcrypt('123456'),
        ]);
    }
}
