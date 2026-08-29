@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            @if (session('status'))
                <div class="alert alert-success">
                    {{ session('status') }}
                </div>
            @endif
            <div class="card">
                <div class="card-header">Data Pembeli</div>
                <div class="card-body">
                <p>
                    <a href="/dashboard/pembeli/create" class="btn btn-primary"> Tambah </a>
                </p>
                <div class="table-responsive">
                    <table class="table">
                    <thead>
                        <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nama</th>
                        <th scope="col">Email</th>
                        <th scope="col">No Telepon</th>
                        <th scope="col">Alamat</th>
                        <th scope="col">Kode Pos</th>
                        <th scope="col">Aksi</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach($data as $row)
                        <tr>
                        <th scope="row">#{{$row->id}}</th>
                        <td>{{$row->nama}}</td>
                        <td>{{$row->email}}</td>
                        <td>{{$row->no_telepon}}</td>
                        <td>{{$row->alamat}}</td>
                        <td>{{$row->kode_pos}}</td>
                        <td><a href="/dashboard/pembeli/edit/{{$row->id}}" class="btn btn-warning">Edit</a>
                            <a href="/dashboard/pembeli/delete/{{$row->id}}" class="btn btn-danger" onclick="return confirm('Yakin Mau Hapus Data ini ??')">Delete</a>
                        </td>
                        </tr>
                       @endforeach
                    </tbody>
                    </table>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>

@endsection