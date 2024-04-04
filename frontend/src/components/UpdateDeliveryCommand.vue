<template>
    <v-card outlined>
        <v-card-title>
            UpdateDelivery
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <Number label="FreightId" v-model="value.freightId" :editMode="editMode"/>
            <Number label="CarOwnerId" v-model="value.carOwnerId" :editMode="editMode"/>
            <Date label="CreatedAt" v-model="value.createdAt" :editMode="editMode"/>
            <String label="State" v-model="value.state" :editMode="editMode"/>
            <Boolean label="IsRecieved" v-model="value.isRecieved" :editMode="editMode"/>
            <Number label="FreightOwnerId" v-model="value.freightOwnerId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateDelivery"
            >
                UpdateDelivery
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'UpdateDeliveryCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.freightId = 0;
            this.value.carOwnerId = 0;
            this.value.createdAt = '2024-04-04';
            this.value.state = '';
            this.value.isRecieved = false;
            this.value.freightOwnerId = 0;
        },
        watch: {
        },
        methods: {
            updateDelivery() {
                this.$emit('updateDelivery', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

