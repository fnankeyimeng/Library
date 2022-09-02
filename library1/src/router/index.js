import Vue from 'vue'
import Router from 'vue-router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import login from "@/components/login";
import bookIndex from "@/components/bookIndex";
import searchBookMo from "@/components/searchBookMo";
import updateBook from "@/components/updateBook";
import userIndex from "@/components/userIndex";
import updateUser from "@/components/updateUser";
import index1 from "@/components/index1";
import addBook from "@/components/addBook";
import register from "@/components/register";
import booklend from "@/components/booklend";
import searchBook from "@/components/searchBook";
import lendList from "@/components/lendList";
import addLend from "@/components/addLend";
import bookIntro from "@/components/bookIntro";
import bookAll from "@/components/bookAll";
import lendAllList from "@/components/lendAllList";
import searchUserMo from "@/components/searchUserMo";
import messOwn from "@/components/messOwn";
Vue.use(Router)
Vue.use(ElementUI)
export default new Router({
    routes: [{
        path: '/',
        name: 'login',
        component: login
    }, {
        path: '/register',
        name: 'register',
        component: register
    },  {
        path: '/bookAll',
        name: 'bookAll',
        component: bookAll,
        children:[{
                path: '/bookIntro',
                name: 'bookIntro',
                component: bookIntro
            },{
            path: '/lendList',
            name: 'lendList',
            component: lendList
        },{
            path: '/booklend',
            name: 'booklend',
            component: booklend
        },{
            path: '/addLend',
            name: 'addLend',
            component: addLend
        },{
            path: '/searchBook',
            name: 'searchBook',
            component: searchBook
        },{
            path: '/messOwn',
            name: 'messOwn',
            component: messOwn
        }
        ]
    },


        {
        path: '/index1',
        name: 'index1',
        component: index1,
        children:[{
            path: '/userIndex',
            name: 'userIndex',
            component: userIndex
        },{
            path: '/bookIndex',
            name: 'bookIndex',
            component: bookIndex
        },{
            path: '/searchBookMo',
            name: 'searchBookMo',
            component: searchBookMo
        },{
            path: '/addBook',
            name: 'addBook',
            component:addBook
        },{
            path: '/updateUser',
            name: 'updateUser',
            component: updateUser
        },{
            path: '/updateBook',
            name: 'updateBook',
            component: updateBook
        },{
            path: '/lendAllList',
            name: 'lendAllList',
            component: lendAllList
        },{
            path: '/searchUserMo',
            name: 'searchUserMo',
            component: searchUserMo
        },
        ]
    }
    ]
})