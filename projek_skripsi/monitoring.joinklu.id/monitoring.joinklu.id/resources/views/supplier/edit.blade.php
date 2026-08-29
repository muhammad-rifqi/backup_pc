@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">Supplier / Edit</div>
                <div class="card-body">
                    <form method="POST" action="/dashboard/supplier/update/{{$data->id}}" enctype="multipart/form-data">
                    {{csrf_field()}}
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="nama" class="form-control" placeholder="Nama Supplier" value="{{$data->nama}}">
                        </div>
                        <div class="col">
                            <input type="text" name="no_telepon" class="form-control" placeholder="No Telepon Supplier" value="{{$data->telepon}}">
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="alamat" class="form-control" placeholder="Alamat Supplier" value="{{$data->alamat}}">
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
