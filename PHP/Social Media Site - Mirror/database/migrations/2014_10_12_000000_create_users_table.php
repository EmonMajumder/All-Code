<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUsersTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('users', function (Blueprint $table) {
            $table->increments('id');
            $table->string('name');
            $table->string('email')->unique();
            $table->string('password');
            $table->timestamp('email_verified_at')->nullable();
            $table->unsignedInteger('created_by')->nullable();
            $table->unsignedInteger('last_modified_by')->nullable();
            $table->timestamps();
            $table->unsignedInteger('deleted_by')->nullable();
            $table->timestamp('deleted_at')->nullable();
            $table->rememberToken();
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
        Schema::dropIfExists('users');
    }
}
