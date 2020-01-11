<?php

namespace App\Policies;

use App\Post;
use App\Theme;
use App\User;
use Illuminate\Auth\Access\HandlesAuthorization;

class PostPolicy
{
    use HandlesAuthorization;

    /**
     * Create a new policy instance.
     *
     * @return void
     */

    public function update(User $user, Post $post)
    {
        return $user->authorizeRoles('Post Moderator');
    }

}
