<?php

use Illuminate\Database\Seeder;

class ThemesTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('themes')->insert([
            'name' => 'Cerulean',
            'cdn_url' => 'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cerulean/bootstrap.min.css',
            'description' => '123456',
            'is_default' => true,
            'created_by' => 3,
        ]);

        DB::table('themes')->insert([
            'name' => 'Cosmo',
            'cdn_url' => 'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css',
            'description' => '123456',
            'created_by' => 3
        ]);

        DB::table('themes')->insert([
            'name' => 'Cyborg',
            'cdn_url' => 'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css',
            'description' => '123456',
            'created_by' => 3
        ]);

        DB::table('themes')->insert([
            'name' => 'Darkly',
            'cdn_url' => 'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css',
            'description' => '123456',
            'created_by' => 3
        ]);

        DB::table('themes')->insert([
            'name' => 'Flatly',
            'cdn_url' => 'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/flatly/bootstrap.min.css',
            'description' => '123456',
            'created_by' => 3
        ]);

        DB::table('themes')->insert([
            'name' => 'Slate',
            'cdn_url' => 'https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/slate/bootstrap.min.css',
            'description' => '123456',
            'created_by' => 3
        ]);
    }
}
