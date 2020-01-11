<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreatePostsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('posts', function (Blueprint $table) {
            $table->increments('id');
            $table->string('title');
            $table->longText('description');
            $table->string('image_url')->nullable();
            $table->integer('likecount')->nullable();
            $table->integer('commentcount')->nullable();
            $table->unsignedInteger('created_by');
            $table->unsignedInteger('last_modified_by')->nullable();
            $table->timestamps();
            $table->unsignedInteger('deleted_by')->nullable();
            $table->timestamp('deleted_at')->nullable();
            $table->foreign('created_by')->references('id')->on('users');
            $table->foreign('last_modified_by')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('posts');
    }
}
