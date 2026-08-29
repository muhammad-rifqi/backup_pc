@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">Pembeli / Create</div>
                <div class="card-body">
                    <form method="POST" action="/dashboard/pembeli/store">
                    {{csrf_field()}}
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="nama" class="form-control" placeholder="nama">
                        </div>
                        <div class="col">
                            <input type="text" name="email" class="form-control" placeholder="email">
                        </div>
                    </div>
                    <br>
                     <div class="form-row">
                        <div class="col">
                            <input type="text" name="alamat" class="form-control" placeholder="alamat">
                        </div>
                    </div>
                    <br>
                     <div class="form-row">
                         <div class="col">
                            <input type="text" name="no_telepon" class="form-control" placeholder="no_telepon">
                        </div>
                        <div class="col">
                            <input type="text" name="kode_pos" class="form-control" placeholder="kode_pos">
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
