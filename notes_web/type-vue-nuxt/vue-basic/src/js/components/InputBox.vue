<template>
    <div id="cp">
    <form @submit.prevent="myLogin">
        <input type="text" placeholder="textbox1" v-model="id" />
        <input type="text" placeholder="textbox2" v-model="pw" />
    </form>
       {{ data.id }}
    </div>
</template>

<script>
export default{
    el: "#cp",
    name: 'login',
    data:{
         id: "",
        pw: "",
    },
    methods:{
        myLogin() {
            console.log("loggingIn");
            console.log(this.id +" " + this.pw);
        }
    }
}
</script>