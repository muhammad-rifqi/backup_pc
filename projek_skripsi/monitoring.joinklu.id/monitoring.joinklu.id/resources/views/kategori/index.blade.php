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
                <div class="card-header">Data Kategori Barang</div>
                <div class="card-body">
                <p>
                    <a href="/dashboard/kategori/create" class="btn btn-primary"> Tambah </a>
                </p>
                <div class="table-responsive">
                    <table class="table">
                    <thead>
                        <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nama Kategori</th>
                        <th scope="col">Aksi</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach($data as $row)
                        <tr>
                        <th scope="row">#{{$row->id}}</th>
                        <td>{{$row->nama_kategori}}</td>
                        <td>
                            <a href="/dashboard/kategori/edit/{{$row->id}}" class="btn btn-warning">Edit</a>
                            <a href="/dashboard/kategori/delete/{{$row->id}}" class="btn btn-danger" onclick="return confirm('Yakin Mau Hapus Data ini ??')">Delete</a>
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