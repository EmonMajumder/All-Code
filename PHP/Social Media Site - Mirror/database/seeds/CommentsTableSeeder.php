<?php

use Illuminate\Database\Seeder;

class CommentsTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('comments')->insert([
            'comment' => 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has',
            'post_id' => 2,
            'user_id' => 5
        ]);

        DB::table('comments')->insert([
            'comment' => 't is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distributio',
            'post_id' => 5,
            'user_id' => 2
        ]);

        DB::table('comments')->insert([
            'comment' => 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard ',
            'post_id' => 1,
            'user_id' => 6
        ]);

        DB::table('comments')->insert([
            'comment' => 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, ',
            'post_id' => 2,
            'user_id' => 8
        ]);

        DB::table('comments')->insert([
            'comment' => 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum"',
            'post_id' => 4,
            'user_id' => 2
        ]);

        DB::table('comments')->insert([
            'comment' => 'Pulvinar sapien et ligula ullamcorper malesuada proin. Morbi tincidunt ornare massa eget egestas purus viverra. Elit duis tristique sollicitudin nibh sit amet.',
            'post_id' => 6,
            'user_id' => 7
        ]);

        DB::table('comments')->insert([
            'comment' => 'Lacus viverra vitae congue eu consequat ac. Tristique nulla aliquet enim tortor at. ',
            'post_id' => 1,
            'user_id' => 4
        ]);

        DB::table('comments')->insert([
            'comment' => 'Est placerat in egestas erat. Vestibulum morbi blandit cursus risus at ultrices. ',
            'post_id' => 4,
            'user_id' => 4
        ]);

        DB::table('comments')->insert([
            'comment' => 'Leo duis ut diam quam nulla. Neque vitae tempus quam pellentesque nec nam aliquam sem et. Enim ut tellus elementum sagittis.',
            'post_id' => 7,
            'user_id' => 2
        ]);

        DB::table('comments')->insert([
            'comment' => 'Nec nam aliquam sem et. Est ullamcorper eget nulla facilisi etiam. Tortor id aliquet lectus proin.',
            'post_id' => 4,
            'user_id' => 2
        ]);

        DB::table('comments')->insert([
            'comment' => 'Faucibus turpis in eu mi bibendum neque egestas congue. Vitae aliquet nec ullamcorper sit amet risus nullam eget felis. Mauris pharetra et ultrices neque ornare aenean ',
            'post_id' => 5,
            'user_id' => 1
        ]);

        DB::table('comments')->insert([
            'comment' => 'Convallis posuere morbi leo urna molestie. Id diam vel quam elementum pulvinar etiam non quam.',
            'post_id' => 2,
            'user_id' => 6
        ]);
    }
}
