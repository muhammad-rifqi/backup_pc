@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">Kategori / Edit</div>
                <div class="card-body">
                    <form method="POST" action="/dashboard/kategori/update/{{$data->id}}" enctype="multipart/form-data">
                    {{csrf_field()}}
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="nama_kategori" class="form-control" placeholder="Nama Kategori" value="{{$data->nama_kategori}}">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12 text-left">
                            <input type="submit" value="Simpan" class="btn btn-primary">
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
