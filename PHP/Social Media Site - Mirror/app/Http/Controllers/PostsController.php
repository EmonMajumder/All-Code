<?php

namespace App\Http\Controllers;

use App\Post;
use App\Post_User;
use App\User;
use Illuminate\Http\Request;
use http\Cookie;

class PostsController extends Controller
{
    public function __construct()
    {
        //$this->middleware('auth');
        $this->middleware('auth', ['except' => ['index']]);
    }

    public function show()
    {
        return view('posts.index');
    }

    public function index()
    {
        $posts=Post::orderby('created_at','desc')->get();
        $newsortby = "Recent";

        if(request()->has('sortby'))
        {
            $sortrequest = request()->validate([ 'sortby' => ['required']]);
            $newsortby = $sortrequest['sortby'];

            if($sortrequest['sortby']=="Like")
            {
                $posts=Post::orderBy('likecount','desc')->get();
            }
            elseif($sortrequest['sortby']=="Comment")
            {
                $posts=Post::orderBy('commentcount','desc')->get();
            }
        }

        return view('posts.index',compact('posts'),compact('newsortby'));
    }

    public function create()
    {
        return view('posts.create');
    }

    public function store()
    {
        $attributes = $this->validatePost();
        $attributes['created_by'] = auth()->id();
        Post::create($attributes);
        return redirect('/posts');
    }

    public function edit(Post $post)
    {
        if($post->created_by == auth()->id()) {
            return view('posts.edit', compact('post'));
        }
        else{
            return redirect('/posts');
        }
    }

    public function update(Post $post)
    {
        if(\request()->has('like'))
        {
            $attributes['likecount'] = $post->likecount+1;
            //dd($attributes);
            $post->update($attributes);
        }
        else if($post->created_by == auth()->id())
        {
            $attributes = $this->validatePost();
            $attributes['last_modified_by'] = auth()->id();
            $attributes['updated_at'] = now();
            $post->update($attributes);
        }
        return redirect('/posts');
    }

    public function likedpost(Post $post, User $user)
    {
        $attributes['post_id'] = $post->id;
        $attributes['user_id'] = $user->id;
        //Post_User::create($attributes);
        return redirect('/posts');
    }

    public function destroy(Post $post)
    {
        if($post->created_by == auth()->id())
        {
            $post->delete();
            return redirect('/posts');
        }
        else{
            $this->authorize('update',$post);
            $post->delete();
            return redirect('/posts');
        }
    }

    public function validatePost()
    {
        return request()->validate([
            'title' => ['required', 'string', 'max:255'],
            'description' => ['required', 'string', 'min:5'],
            'image_url' => ['string']
        ]);
    }
}
