
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import FreightFreightManager from "./components/listers/FreightFreightCards"
import FreightFreightDetail from "./components/listers/FreightFreightDetail"

import DeliveryFreightDeliveryManager from "./components/listers/DeliveryFreightDeliveryCards"
import DeliveryFreightDeliveryDetail from "./components/listers/DeliveryFreightDeliveryDetail"

import SettlementSettlementManager from "./components/listers/SettlementSettlementCards"
import SettlementSettlementDetail from "./components/listers/SettlementSettlementDetail"

import ArlimNotificationManager from "./components/listers/ArlimNotificationCards"
import ArlimNotificationDetail from "./components/listers/ArlimNotificationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/freights/freights',
                name: 'FreightFreightManager',
                component: FreightFreightManager
            },
            {
                path: '/freights/freights/:id',
                name: 'FreightFreightDetail',
                component: FreightFreightDetail
            },

            {
                path: '/deliveries/freightDeliveries',
                name: 'DeliveryFreightDeliveryManager',
                component: DeliveryFreightDeliveryManager
            },
            {
                path: '/deliveries/freightDeliveries/:id',
                name: 'DeliveryFreightDeliveryDetail',
                component: DeliveryFreightDeliveryDetail
            },

            {
                path: '/settlements/settlements',
                name: 'SettlementSettlementManager',
                component: SettlementSettlementManager
            },
            {
                path: '/settlements/settlements/:id',
                name: 'SettlementSettlementDetail',
                component: SettlementSettlementDetail
            },

            {
                path: '/arlims/notifications',
                name: 'ArlimNotificationManager',
                component: ArlimNotificationManager
            },
            {
                path: '/arlims/notifications/:id',
                name: 'ArlimNotificationDetail',
                component: ArlimNotificationDetail
            },



    ]
})
