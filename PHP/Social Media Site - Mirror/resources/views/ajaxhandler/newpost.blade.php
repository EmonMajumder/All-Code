<div class="col-md-6">
    <div class="card">
        <div class="card-header">
            <div class="row">
                <div style="width:100%">
                    {{$post->title}}
                    @if(auth()->user())
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
        </div>

        <div class="card-body">
            <div class="row justify-content-center">
                <form action="/posts/{{$post->id}}/{{auth()->user()->id}}"  method="post">
                    @method('PATCH')
                    @csrf
                    <input hidden name="like" id="like" value="like">
                    <button type="submit">Like</button>
                    <button type="submit">Unlike</button>
                </form>
            </div>
        </div>
    </div>
</div>

