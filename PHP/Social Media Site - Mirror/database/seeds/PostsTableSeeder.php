<?php

use Illuminate\Database\Seeder;

class PostsTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('posts')->insert([
            'title' => 'A Day with emon',
            'description' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac felis donec et odio pellentesque diam volutpat commodo sed. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Enim blandit volutpat maecenas volutpat blandit aliquam etiam. Nunc sed velit dignissim sodales ut eu sem. Erat nam at lectus urna. Venenatis a condimentum vitae sapien pellentesque habitant. Purus sit amet luctus venenatis lectus magna. Dictumst vestibulum rhoncus est pellentesque elit. Amet nisl suscipit adipiscing bibendum est ultricies integer quis auctor. Leo a diam sollicitudin tempor id eu. Dapibus ultrices in iaculis nunc',
            'image_url' => 'emon.jpeg',
            'created_at' => now(),
            'created_by' => 3,
            'likecount' => 45
        ]);

        DB::table('posts')->insert([
            'title' => 'Witcher: Best game ever',
            'description' => 'In hac habitasse platea dictumst quisque sagittis. Suspendisse in est ante in nibh mauris cursus. Ornare quam viverra orci sagittis eu volutpat odio facilisis. Cum sociis natoque penatibus et magnis. Nec feugiat in fermentum posuere urna nec tincidunt. Maecenas ultricies mi eget mauris pharetra et. Massa tincidunt nunc pulvinar sapien et ligula. Vitae purus faucibus ornare suspendisse sed nisi. Scelerisque eu ultrices vitae auctor eu augue ut lectus. Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Ullamcorper a lacus vestibulum sed arcu non odio euismod.',
            'image_url' => 'witcher.png',
            'created_at' => now(),
            'created_by' => 2,
            'likecount' => 21
        ]);

        DB::table('posts')->insert([
            'title' => 'Star Wars: The great movie franchise',
            'description' => 'Porttitor rhoncus dolor purus non enim. Maecenas pharetra convallis posuere morbi leo urna molestie at. Lacus vestibulum sed arcu non odio euismod. At auctor urna nunc id cursus metus aliquam. Nec ullamcorper sit amet risus nullam eget. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam. Cras ornare arcu dui vivamus. Integer enim neque volutpat ac. Justo donec enim diam vulputate ut pharetra. Quis enim lobortis scelerisque fermentum dui faucibus in ornare. Eget mi proin sed libero enim sed faucibus turpis in. Facilisi nullam vehicula ipsum a arcu cursus. Senectus et netus et malesuada fames ac. Elementum facilisis leo vel fringilla est. Egestas sed sed risus pretium quam vulputate dignissim.',
            'image_url' => 'starwar.jpeg',
            'created_at' => now(),
            'created_by' => 2,
            'likecount' => 12
        ]);

        DB::table('posts')->insert([
            'title' => 'Bangladesh: Economy on rise',
            'description' => 'Neque laoreet suspendisse interdum consectetur libero id faucibus nisl. Lorem sed risus ultricies tristique. Laoreet id donec ultrices tincidunt arcu. Sapien pellentesque habitant morbi tristique senectus et netus et malesuada. Volutpat odio facilisis mauris sit amet massa. Consectetur adipiscing elit duis tristique. Eu lobortis elementum nibh tellus molestie nunc non. Eu ultrices vitae auctor eu augue ut lectus. Consequat mauris nunc congue nisi vitae suscipit tellus. Fringilla est ullamcorper eget nulla facilisi.',
            'created_at' => now(),
            'created_by' => 5,
            'likecount' => 25
        ]);

        DB::table('posts')->insert([
            'title' => 'AI: The future is secured',
            'description' => 'Suspendisse in est ante in nibh mauris cursus. Venenatis urna cursus eget nunc scelerisque viverra mauris. Quisque id diam vel quam elementum pulvinar. Turpis massa sed elementum tempus egestas sed sed. Lectus magna fringilla urna porttitor. Est ante in nibh mauris. Purus viverra accumsan in nisl nisi scelerisque. Dui nunc mattis enim ut tellus elementum sagittis vitae. In fermentum posuere urna nec tincidunt praesent semper. Eget nunc lobortis mattis aliquam.',
            'image_url' => 'ai.jpg',
            'created_at' => now(),
            'created_by' => 3,
            'likecount' => 2
        ]);

        DB::table('posts')->insert([
            'title' => 'Climate Change: Act now',
            'description' => 'In hac habitasse platea dictumst quisque sagittis. Suspendisse in est ante in nibh mauris cursus. Ornare quam viverra orci sagittis eu volutpat odio facilisis. Cum sociis natoque penatibus et magnis. Nec feugiat in fermentum posuere urna nec tincidunt. Maecenas ultricies mi eget mauris pharetra et. Massa tincidunt nunc pulvinar sapien et ligula. Vitae purus faucibus ornare suspendisse sed nisi. Scelerisque eu ultrices vitae auctor eu augue ut lectus. Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Ullamcorper a lacus vestibulum sed arcu non odio euismod.',
            'image_url' => 'climatechange.jpg',
            'created_at' => now(),
            'created_by' => 1,
            'likecount' => 30

        ]);

        DB::table('posts')->insert([
            'title' => 'NSCC: Right place to build your future',
            'description' => 'Neque ornare aenean euismod elementum nisi quis eleifend quam adipiscing. Quam nulla porttitor massa id neque aliquam. Morbi enim nunc faucibus a pellentesque. Diam sit amet nisl suscipit adipiscing bibendum. Bibendum neque egestas congue quisque egestas diam in arcu cursus. Enim neque volutpat ac tincidunt vitae semper quis. Pellentesque habitant morbi tristique senectus. Eget velit aliquet sagittis id consectetur purus ut faucibus. Tellus in hac habitasse platea. Nam at lectus urna duis convallis convallis tellus id interdum. Pharetra et ultrices neque ornare aenean euismod.',
            'image_url' => 'nscc.jpg',
            'created_by' => 5,
            'likecount' => 225
        ]);

        DB::table('posts')->insert([
            'title' => 'Real Madrid: The best in history',
            'description' => 'Ut aliquam purus sit amet luctus venenatis lectus magna. Tincidunt praesent semper feugiat nibh. Eleifend mi in nulla posuere sollicitudin aliquam. Et molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit. Dui sapien eget mi proin sed libero enim. Mi eget mauris pharetra et ultrices neque ornare aenean euismod. Ut lectus arcu bibendum at varius vel. Pretium fusce id velit ut tortor. Venenatis urna cursus eget nunc.',
            'image_url' => 'realmadrid.jpg',
            'created_at' => now(),
            'created_by' => 6,
            'likecount' => 7
        ]);

        DB::table('posts')->insert([
            'title' => 'Walmart: Get boost in sale before Christmas',
            'description' => 'Nullam eget felis eget nunc lobortis mattis aliquam faucibus purus. Enim sit amet venenatis urna cursus eget nunc. Ut tortor pretium viverra suspendisse potenti. Et malesuada fames ac turpis egestas sed. Ac tortor dignissim convallis aenean et tortor at. Lacus sed viverra tellus in hac habitasse platea. Turpis egestas maecenas pharetra convallis posuere morbi. Leo duis ut diam quam nulla porttitor. Etiam dignissim diam quis enim lobortis.',
            'image_url' => 'walmart.jpg',
            'created_at' => now(),
            'created_by' => 8,
            'likecount' => 83
        ]);
    }
}
