@extends('layouts.app')

@section('content')

    <div class="container">
        @if(auth()->id())
            <div class="align-content-center">
                <div class="row justify-content-center">
                    <input type="button" onclick="location.href='/posts/create';" value="Create New Post" />
                    <p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    <input type="button" onclick="location.href='/themes';" value="Choose Theme" />
                    <p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    <form action="/posts" method="get">
                        @csrf
                        <label>Sort by</label>
                        <select id = "sortby" name="sortby" onchange="this.form.submit()">
                            <option {{$newsortby == 'Recent' ? 'selected':''}} value = "Recent">Recent</option>
                            <option {{$newsortby == 'Like' ? 'selected':''}} value = "Like">Like</option>
                            <option {{$newsortby == 'Comment' ? 'selected':''}} value = "Comment">Comment</option>
                        </select>
                    </form>
                </div>
            </div>
        @endif

        <br>
        <div class="row justify-content-center" id="divforpost">
            @foreach($posts as $post)
                @if(!$post->deleted_at)
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header">
                                <div class="row">
                                    <div style="width:100%">
                                        {{$post->title}}
                                        @if(auth()->id())
                                            @if(auth()->user()->hasrole('Post Moderator') || auth()->id() == $post->created_by)
                                                <form action="/posts/{{$post->id}}"  method="post">
                                                    @method('DELETE')
                                                    @csrf
                                                    <button class="btn btn-secondary float-right" type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                                                </form>
                                            @endif
                                            @if(auth()->id()==$post->created_by)
                                                <div class="float-right">&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                            <button class="btn btn-secondary float-right" onclick="location.href='/posts/{{$post->id}}/edit';">Edit</button>
                                            @endif
                                        @endif
                                    </div>
                                </div>
                                <div style="text-align:right">
                                    {{$post->created_at}}
                                    <br>
                                    BY {{$users=\App\User::where('id',$post->created_by)->first()->name}}
                                </div>
                            </div>

                            <div class="card-body">
                                <div class="row justify-content-center">
                                    @if($post->image_url)
                                        <div class="card-img">
                                            <img src="{{$post->image_url}}" style="width:100%">
                                        </div>
                                    @endif
                                    {{$post->description}}
                                </div>
                                <br>
                                <div class="card">
                                    <div class="card-header">
                                        <div class="row">
                                            Comment
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <div class="row justify-content-center">
                                            <div style="width:100%">
                                                <form action="/comments"  method="post">
                                                    @csrf
                                                    <input hidden id="post_id" name="post_id" value="{{$post->id}}">
                                                    <input type="text" id="comment" name="comment" placeholder="Comment" required style="width:100%";>
                                                    <button class="btn btn-secondary float-right" type="submit">Give feedback</button>
                                                </form>
                                            </div>

                                            @foreach($comments = \App\Post::find($post->id)->comments as $comment)
                                                <div style="border-style: solid; border-color: coral; width:100%">
                                                    {{$comment->comment}}
                                                    <br>
                                                    <div style="text-align:right">
                                                        - by {{$comment->user->name}}
                                                    </div>
                                                    @if(auth()->id())
                                                        @if(auth()->user()->hasrole('Post Moderator') || $comment->user_id == auth()->id())
                                                            <form action="/comments/{{$comment->id}}"  method="post">
                                                                @method('DELETE')
                                                                @csrf
                                                                <button class="btn btn-secondary float-right" type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                                                            </form>
                                                        @endif
                                                    @endif
                                                </div>
                                            @endforeach
                                        </div>
                                    </div>
                                </div>
                            </div>

                            @if(auth()->id())
                                <div class="card-body">
                                    <div class="row justify-content-center">
                                        <p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
                                        <form action="/posts/{{$post->id}}"  method="POST">
                                            @method('PATCH')
                                            @csrf
                                            <input hidden name="like" id="like" value="like()">
                                            <button type="submit">Like&nbsp;&nbsp;({{$post->likecount}})</button>
                                        </form>
                                    </div>
                                </div>
                            @endif
                        </div>
                    </div>
                @endif
            @endforeach
        </div>

        @php
            $post=DB::table('posts')->latest()->first();
        @endphp

        <script>

            var lastpostid = "{{($post->id)}}";
            var lastpostidint = parseInt(lastpostid);
             function pollnewpost(){
                 $.ajax({

                     url: "/ajaxcallnewpost/"+lastpostid,
                     success: function(result){
                         if(result.length>0){
                             $("#divforpost").eq(0).prepend($.parseHTML(result));
                             lastpostidint++;
                             lastpostid = lastpostidint.toString();
                         }
                         setTimeout(pollnewpost,5000);
                     }
                 })
             }
            setTimeout(pollnewpost,5000);
        </script>
    </div>
@endsection
