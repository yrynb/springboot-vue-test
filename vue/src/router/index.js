import Vue from 'vue'
import VueRouter from 'vue-router'
import BookManage from '../views/BookManage'
import AddBook from '../views/AddBook'
import Index from '../views/Index'
import BookUpdate from '../views/BookUpdate'
import ChangePassword from "@/views/ChangePassword";
import EmpSalary from "@/views/empsalary/EmpSalary";
import SalaryUpdate from "@/views/empsalary/SalaryUpdate";
import AddSalary from "@/views/empsalary/AddSalary";

Vue.use(VueRouter)

const routes = [
  {
    path:"/",
    name:"员工管理",
    component:Index,
    show:true,
    redirect:"/BookManage",
    children:[
      {
        path:"/BookManage",
        name:"查询员工",
        component:BookManage
      },
      {
        path:"/AddBook",
        name:"添加员工",
        component:AddBook
      }
    ]
  },
  {
    // path: "/EmpSalary",
    path: "/",
    name: "员工工资信息",
    component: Index,
    redirect:"/CheckSalary",
    show:true,
    children: [
      {
        path: "/CheckSalary",
        name:'查看工资',
        component: EmpSalary
      },
      {
        path: "/AddSalary",
        name:'添加工资记录',
        component: AddSalary
      }
    ]
  },
  {
    path: "/profile",
    name: "我的",
    component: ChangePassword,
    show:true,
    children: [
      {
        path: "/ChangePasswod",
        name:'修改密码',
        component: ChangePassword
      }
    ]
  },
  {
    path:'/update',
    component:BookUpdate,
    show:false
  },
  {
    path:'/SalaryUpdate',
    component: SalaryUpdate,
    show: false
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
