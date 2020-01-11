<?php

namespace App\Http\Controllers;

use App\Comment;
use App\Post;
use App\User;
use Illuminate\Http\Request;

class CommentsController extends Controller
{
    public function __construct()
    {
        //$this->middleware('auth');
        $this->middleware('auth', ['except' => ['index']]);
    }

    public function show()
    {
        return view('comments.index');
    }

    public function index()
    {
        return view('comments.index');
    }

    public function create()
    {
        return view('comments.create');
    }

    public function store()
    {
        $attributes = $this->validatePost();
        $attributes['user_id'] = auth()->id();
        Comment::create($attributes);
        $attpost = $attributes['post_id'];
        $post = \App\Post::find($attpost);
        $attributeforpost['commentcount'] = $post->commentcount + 1;

        //dd($post->commentcount + 1);
        $post->update($attributeforpost);
        return redirect('/posts');
    }

    public function edit(Comment $comment)
    {
        if($comment->created_by == auth()->id()) {
            return view('comments.edit', compact('comment'));
        }
        else{
            return redirect('/posts');
        }
    }

    public function update(Comment $comment)
    {
        if($comment->created_by == auth()->id())
        {
            $attributes = $this->validatePost();
            $attributes['last_modified_by'] = auth()->id();
            $attributes['updated_at'] = now();
            $comment->update($attributes);
        }
        return redirect('/posts');
    }

    public function destroy(Comment $comment)
    {
        if($comment->user_id == auth()->id())
        {
            $comment->delete();
            return redirect('/posts');
        }
        else{
            $this->authorize('update',$comment);
            $comment->delete();
            return redirect('/posts');
        }
    }

    public function validatePost()
    {
        return request()->validate([
            'comment' => ['required', 'string', 'max:255'],
            'post_id' => ['required', 'int'],
        ]);
    }
}
