<?php

namespace App\Http\Controllers;

use App\Post;
use Illuminate\Http\Request;

class AjaxController extends Controller
{
    public function update(Post $post)
    {
        $newpost = Post::all()->where('created_at','>',$post->created_at)->first();

        if($newpost)
        {
            return view ('ajaxhandler.newpost')->with('post',$newpost);
        }
    }
}
